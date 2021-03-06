package com.sangcomz.fishbun.bean;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2014-12-22.
 */
public class ImageBean implements Parcelable {
    int imgOrder;
    Uri imgUri;
    boolean isInit = false;


    public ImageBean(int imgOrder, Uri imgPath) {
        this.imgOrder = imgOrder;
        this.imgUri = imgPath;
    }

    public int getImgOrder() {
        return imgOrder;
    }

    public void setImgOrder(int imgOrder) {
        this.imgOrder = imgOrder;
    }

    public Uri getImgPath() {
        return imgUri;
    }

    public void setImgPath(Uri imageUri) {
        this.imgUri = imgUri;
    }

    public boolean isInit() {
        return isInit;
    }

    public void setIsInit(boolean isInit) {
        this.isInit = isInit;
    }


    protected ImageBean(Parcel in) {
        imgOrder = in.readInt();
        imgUri = Uri.parse(in.readString());
        isInit = (boolean) in.readValue(Boolean.class.getClassLoader());
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imgOrder);
        parcel.writeString(imgUri.toString());
        parcel.writeValue(isInit);
    }


    public static final Creator<ImageBean> CREATOR = new Creator<ImageBean>() {
        @Override
        public ImageBean createFromParcel(Parcel in) {
            return new ImageBean(in);
        }

        @Override
        public ImageBean[] newArray(int size) {
            return new ImageBean[size];
        }
    };

//
//    public void readFromParcel(Parcel parcel) {
//        imgOrder = parcel.readInt();
//        imgPath = parcel.readString();
//        isInit = parcel.readValue();
//    }
}
