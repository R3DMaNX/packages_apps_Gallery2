package com.android.gallery3d.filtershow.filters;

import android.graphics.Bitmap;

import com.android.gallery3d.R;

public class ImageFilterNegative extends ImageFilter {

    public ImageFilterNegative() {
        mName = "Negative";
    }

    public FilterRepresentation getDefaultRepresentation() {
        FilterRepresentation representation = new FilterDirectRepresentation("Negative");
        representation.setFilterClass(ImageFilterNegative.class);
        representation.setTextId(R.string.negative);
        representation.setButtonId(R.id.negativeButton);
        representation.setShowEditingControls(false);
        representation.setShowParameterValue(false);
        return representation;
    }

    native protected void nativeApplyFilter(Bitmap bitmap, int w, int h);

    @Override
    public Bitmap apply(Bitmap bitmap, float scaleFactor, boolean highQuality) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        nativeApplyFilter(bitmap, w, h);
        return bitmap;
    }
}