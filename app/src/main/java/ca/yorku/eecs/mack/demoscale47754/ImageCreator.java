package ca.yorku.eecs.mack.demoscale47754;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ImageCreator {

    public static Drawable uriToDrawable(Context context, Uri uri) {
        try {
            // Open an input stream from the Uri using ContentResolver
            ContentResolver contentResolver = context.getContentResolver();
            InputStream inputStream = contentResolver.openInputStream(uri);

            // Decode the input stream into a Bitmap
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

            // Close the input stream
            if (inputStream != null) {
                inputStream.close();
            }

            // Convert the Bitmap to a Drawable
            return new BitmapDrawable(context.getResources(), bitmap);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}