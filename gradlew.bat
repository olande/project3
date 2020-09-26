<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/user"
    android:orientation="vertical"
    tools:context=".AdminJob">
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_marginTop="20dp"
        android:layout_height="80dp"
        android:orientation="horizontal">
            <de.hdodenhof.circleimageview.CircleImageView
                android:layout_width="150dp"
                android:id="@+id/Bins"
                android:layout_height="80dp"
                android:src="@drawable/bin"
                android:layout_marginRight="20dp"
                android:layout_marginLeft="20dp">
            </de.hdodenhof.circleimageview.CircleImageView>

        <Button
            android:id="@+id/createbin"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="20dp"
            android:text="Create Bin"></Button>
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_marginTop="5dp"
        android:layout_height="80dp"
        android:orientation="horizontal">
        <de.hdodenhof.circleimageview.CircleImageView
            android:layout_width="150dp"
            android:id="@+id/Binsupdate"
            android:layout_height="80dp"
            android:src="@drawable/smartbins"
            android:layout_marginRight="20dp"
            android:layout_marginLeft="20dp">
        </de.hdodenhof.circleimageview.CircleImageView>
        <Button
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="20dp"
            android:text="Update Bin"
            ></Button>
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_marginTop="5dp"
        android:layout_height="80dp"
        android:orientation="hori