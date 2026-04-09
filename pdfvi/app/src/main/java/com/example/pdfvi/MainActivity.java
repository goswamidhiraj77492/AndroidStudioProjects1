package com.example.pdfvi;

import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    ZoomableImageView imageView;

    Button btnNext, btnPrev;
    TextView pageNumber;

    PdfRenderer pdfRenderer;
    PdfRenderer.Page currentPage;
    ParcelFileDescriptor fileDescriptor;

    int currentPageIndex = 0;
    int totalPages = 0;

    File file;

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
        imageView = findViewById(R.id.imageView);
        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);
        pageNumber = findViewById(R.id.pageNumber);

        copyPdfFromAssets();

        openPdf();

        showPage(currentPageIndex);

        btnNext.setOnClickListener(v -> nextPage());

        btnPrev.setOnClickListener(v -> prevPage());

        imageView.setOnSwipeListener(new ZoomableImageView.OnSwipeListener() {
            @Override
            public void onSwipeLeft() {
                nextPage();
            }

            @Override
            public void onSwipeRight() {
                prevPage();
            }
        });
    }

    private void nextPage() {
        if (currentPageIndex < totalPages - 1) {
            currentPageIndex++;
            showPage(currentPageIndex);
        }
    }

    private void prevPage() {
        if (currentPageIndex > 0) {
            currentPageIndex--;
            showPage(currentPageIndex);
        }
    }

    // 📁 Copy PDF from assets
    private void copyPdfFromAssets() {
        file = new File(getCacheDir(), "bca.pdf");

        try {
            InputStream input = getAssets().open("bca.pdf");
            FileOutputStream output = new FileOutputStream(file);

            byte[] buffer = new byte[1024];
            int size;

            while ((size = input.read(buffer)) != -1) {
                output.write(buffer, 0, size);
            }

            input.close();
            output.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 📄 Open PDF
    private void openPdf() {
        try {
            fileDescriptor = ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY);
            pdfRenderer = new PdfRenderer(fileDescriptor);
            totalPages = pdfRenderer.getPageCount();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🖼 Show Page
    private void showPage(int index) {
        if (currentPage != null) {
            currentPage.close();
        }

        try {
            currentPage = pdfRenderer.openPage(index);

            Bitmap bitmap = Bitmap.createBitmap(
                    currentPage.getWidth(),
                    currentPage.getHeight(),
                    Bitmap.Config.ARGB_8888
            );

            currentPage.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);

            imageView.setImageBitmap(bitmap);
            imageView.resetZoom();

            pageNumber.setText("Page " + (index + 1) + " / " + totalPages);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔒 Close resources
    @Override
    protected void onDestroy() {
        super.onDestroy();

        try {
            if (currentPage != null) currentPage.close();
            if (pdfRenderer != null) pdfRenderer.close();
            if (fileDescriptor != null) fileDescriptor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
