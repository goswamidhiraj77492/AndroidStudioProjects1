package com.example.ai;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.github.barteksc.pdfviewer.PDFView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PDFView pdfView = findViewById(R.id.pdfView);
        
        // Ensure you have a 'sample.pdf' file in your src/main/assets folder.
        // If the folder doesn't exist, create it: src/main/assets/
        pdfView.fromAsset("sample.pdf")
                .load();
    }
}
