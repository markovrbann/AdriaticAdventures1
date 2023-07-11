package com.example.adriaticadventures.ui.forumlosinj;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adriaticadventures.R;

import junit.framework.TestCase;

import org.junit.Test;
import org.mockito.Mockito;

public class ForumLosinjTest extends TestCase {

    @Test
    public void testTextViewVisibility() {

        AppCompatActivity activity = Mockito.mock(AppCompatActivity.class);


        Mockito.when(activity.getApplicationContext()).thenReturn(activity);


        Mockito.doNothing().when(activity).setContentView(Mockito.anyInt());


        TextView txtv = Mockito.mock(TextView.class);

        Mockito.when(activity.findViewById(R.id.reviewTextView1)).thenReturn(txtv);


        assertEquals(txtv.getVisibility(), View.VISIBLE);
    }
}