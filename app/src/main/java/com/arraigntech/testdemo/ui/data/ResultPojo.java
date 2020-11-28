package com.arraigntech.testdemo.ui.data;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.arraigntech.testdemo.R;
import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultPojo {

    @SerializedName("items")
    public List<Items> items;
    @SerializedName("totalItems")
    public int totalItems;
    @SerializedName("kind")
    public String kind;

    public static class Items {
        @SerializedName("searchInfo")
        public SearchInfo searchInfo;
        @SerializedName("accessInfo")
        public AccessInfo accessInfo;
        @SerializedName("saleInfo")
        public SaleInfo saleInfo;
        @SerializedName("volumeInfo")
        public VolumeInfo volumeInfo;
        @SerializedName("selfLink")
        public String selfLink;
        @SerializedName("etag")
        public String etag;
        @SerializedName("id")
        public String id;
        @SerializedName("kind")
        public String kind;
    }

    public static class SearchInfo {
        @SerializedName("textSnippet")
        public String textSnippet;
    }

    public static class AccessInfo {
        @SerializedName("quoteSharingAllowed")
        public boolean quoteSharingAllowed;
        @SerializedName("accessViewStatus")
        public String accessViewStatus;
        @SerializedName("webReaderLink")
        public String webReaderLink;
        @SerializedName("pdf")
        public Pdf pdf;
        @SerializedName("epub")
        public Epub epub;
        @SerializedName("textToSpeechPermission")
        public String textToSpeechPermission;
        @SerializedName("publicDomain")
        public boolean publicDomain;
        @SerializedName("embeddable")
        public boolean embeddable;
        @SerializedName("viewability")
        public String viewability;
        @SerializedName("country")
        public String country;
    }

    public static class Pdf {
        @SerializedName("isAvailable")
        public boolean isAvailable;
    }

    public static class Epub {
        @SerializedName("isAvailable")
        public boolean isAvailable;
    }

    public static class SaleInfo {
        @SerializedName("isEbook")
        public boolean isEbook;
        @SerializedName("saleability")
        public String saleability;
        @SerializedName("country")
        public String country;
    }

    public static class VolumeInfo {
        @SerializedName("canonicalVolumeLink")
        public String canonicalVolumeLink;
        @SerializedName("infoLink")
        public String infoLink;
        @SerializedName("previewLink")
        public String previewLink;
        @SerializedName("language")
        public String language;
        @SerializedName("imageLinks")
        public ImageLinks imageLinks;
        @SerializedName("contentVersion")
        public String contentVersion;
        @SerializedName("allowAnonLogging")
        public boolean allowAnonLogging;
        @SerializedName("maturityRating")
        public String maturityRating;
        @SerializedName("categories")
        public List<String> categories;
        @SerializedName("printType")
        public String printType;
        @SerializedName("pageCount")
        public int pageCount;
        @SerializedName("readingModes")
        public ReadingModes readingModes;
        @SerializedName("industryIdentifiers")
        public List<IndustryIdentifiers> industryIdentifiers;
        @SerializedName("publishedDate")
        public String publishedDate;
        @SerializedName("publisher")
        public String publisher;
        @SerializedName("title")
        public String title;
    }

    public static class ImageLinks {
        @SerializedName("thumbnail")
        public String thumbnail;
        @SerializedName("smallThumbnail")
        public String smallThumbnail;

        @BindingAdapter("thumbnailImage")
        public static void loadImage(ImageView view, String imageUrl) {
            Glide.with(view.getContext())
                    .load(imageUrl.equalsIgnoreCase("")|| imageUrl==null? R.drawable.placeholder:imageUrl)
                    .into(view);
        }
    }

    public static class ReadingModes {
        @SerializedName("image")
        public boolean image;
        @SerializedName("text")
        public boolean text;
    }

    public static class IndustryIdentifiers {
        @SerializedName("identifier")
        public String identifier;
        @SerializedName("type")
        public String type;
    }
}
