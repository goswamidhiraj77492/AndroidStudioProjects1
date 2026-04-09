package com.example.notehub;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.barteksc.pdfviewer.PDFView;

public class MainPdfViewActivity extends AppCompatActivity {
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_pdf_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        pdfView = findViewById(R.id.pdfView);
        pdfView.setBackgroundColor(android.graphics.Color.LTGRAY);

        String title = getIntent().getStringExtra("title");
        String name = getIntent().getStringExtra("name");

        // The condition was using 'bca.pdf' which was a syntax error.
        // It should be a string literal "bca.pdf" referring to the asset.
        if ("F1001 Business Communication Notes".equals(title) ) {
            addPdf("bca.pdf", pdfView);
        }
    }

    void addPdf(String pdfName, PDFView pdfView) {
        pdfView.fromAsset(pdfName)
                .enableSwipe(true)
                .enableDoubletap(true)
                .swipeHorizontal(false)
                .defaultPage(0)
                .pageSnap(true)
                .pageFling(true)
                .spacing(5)
                .enableAnnotationRendering(false)
                .load();
    }
}
