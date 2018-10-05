package spoticesar.uniftec.com.br.spoticesar.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import spoticesar.uniftec.com.br.spoticesar.R;

public class ImageActivity extends AppCompatActivity {

    private ImageView imageWebImage;

    private static String URI = "https://bognarjunior.files.wordpress.com/2018/01/1crcyaithv7aiqh1z93v99q.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagens);

        this.imageWebImage = findViewById(R.id.web_image_view);

        Picasso.with(this)
                .load(URI)
                .into(this.imageWebImage);

    }

}
