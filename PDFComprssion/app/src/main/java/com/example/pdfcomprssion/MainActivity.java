package com.example.pdfcomprssion;


import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {

    private static  final int PICK_PDF =1;

    Uri pdfUri;
    TextView fileName, fileSize, resultSize;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button selectBtn = findViewById(R.id.selectpdf);
        Button compressBtn = findViewById(R.id.compresspdf);

        fileName = findViewById(R.id.fileName);
        fileSize = findViewById(R.id.filesize);
        resultSize = findViewById(R.id.resultSize);
        progressBar = findViewById(R.id.progressBar);

        selectBtn.setOnClickListener(v -> selectPDF());

        compressBtn.setOnClickListener(v -> {
            if (pdfUri != null) {
                compressPDF();
            } else {
                Toast.makeText(this, "Select a PDF first!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void selectPDF() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("application/pdf");
        startActivityForResult(intent,PICK_PDF);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_PDF && resultCode == RESULT_OK && data != null) {
            pdfUri = data.getData();

            // File Name
            Cursor cursor = getContentResolver().query(pdfUri, null, null, null, null);
            if (cursor != null) {
                int nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
                int sizeIndex = cursor.getColumnIndex(OpenableColumns.SIZE);
                cursor.moveToFirst();

                fileName.setText("File: " + cursor.getString(nameIndex));
                fileSize.setText("Size: " + formatSize(cursor.getLong(sizeIndex)));

                cursor.close();
            }
        }
    }

    private void compressPDF() {
        progressBar.setVisibility(View.VISIBLE);

        new Thread(() -> {
            try {
                InputStream inputStream =
                        getContentResolver().openInputStream(pdfUri);

                File tempFile = new File(getCacheDir(),"temp.pdf");

                FileOutputStream out = new FileOutputStream(tempFile);

                byte[] buffer = new byte[1024];
                int read;

                while((read=inputStream.read(buffer))!=-1){
                    out.write(buffer,0,read);
                }

                out.close();
                inputStream.close();

                String tempInputPath = tempFile.getAbsolutePath();

                // Output path in Downloads
                String output = Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                        + "/compressed_"+System.currentTimeMillis()+".pdf";

                PdfReader reader = new PdfReader(tempInputPath);
                PdfWriter writer = new PdfWriter(output);

                writer.setCompressionLevel(9);

                PdfDocument pdfDoc = new PdfDocument(reader,writer);
                pdfDoc.close();

                File newFile = new File(output);

                runOnUiThread(() -> {

                    progressBar.setVisibility(View.GONE);

                    resultSize.setText(
                            "Saved in Downloads\nCompressed Size: "+
                                    formatSize(newFile.length())
                    );

                    Toast.makeText(this,
                            "PDF saved to Downloads",
                            Toast.LENGTH_LONG).show();
                });

            }catch(Exception e){

                runOnUiThread(() -> {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(this,
                            "Error: "+e.getMessage(),
                            Toast.LENGTH_LONG).show();
                });

            }

        }).start();
    }

    private String formatSize(long size) {
        double kb = size / 1024.0;
        double mb = kb / 1024.0;

        if (mb >= 1) return String.format("%.2f MB", mb);
        else return String.format("%.2f KB", kb);

    }
}