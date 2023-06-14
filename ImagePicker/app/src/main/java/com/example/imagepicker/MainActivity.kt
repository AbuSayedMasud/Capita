import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.imagepicker.databinding.ActivityMainBinding
import com.github.esafirm.imagepicker.features.ImagePicker
import com.github.esafirm.imagepicker.model.Image
import com.google.android.gms.cast.framework.media.ImagePicker

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var image: ImageView
    private lateinit var button: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        image = binding.imageView
        button = binding.floatingActionButton

        button.setOnClickListener {
            ImagePicker.create(this) // Activity or Fragment
                .single() // Single or Multi Image Selection
                .start()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == ImagePicker.REQUEST_CODE) {
            val images = ImagePicker.getImages(data)
            if (images.isNotEmpty()) {
                val selectedImageUri = images[0].uri
                // Use the selected image URI as needed (e.g., display in ImageView)
                image.setImageURI(selectedImageUri)
            }
        }
    }
}
