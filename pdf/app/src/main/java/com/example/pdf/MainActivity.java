package com.example.pdf;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.barteksc.pdfviewer.PDFView;

public class MainActivity extends AppCompatActivity {

    PDFView pdfView;

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
        
        pdfView = findViewById(R.id.pdfView);
        pdfView.setBackgroundColor(android.graphics.Color.LTGRAY);

        // Make sure you have a file named "BCA.pdf" in your assets folder
        pdfView.fromAsset("BCA.pdf")

                .enableSwipe(true)
                .enableDoubletap(true)
                .swipeHorizontal(false) 
                .defaultPage(1)
                .pageSnap(true)

                .pageFling(true)

                .spacing(5)

                       // 👉 Space between pages (adjust)
                .enableAnnotationRendering(false)
                .load();
    }
}
