package com.example.adriaticadventures.ui.forumkrk;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adriaticadventures.R;

import junit.framework.TestCase;

import org.junit.Test;
import org.mockito.Mockito;

public class ForumKrkTest extends TestCase {

    @Test
    public void testButtonVisibility() {

        AppCompatActivity activity = Mockito.mock(AppCompatActivity.class);


        Mockito.when(activity.getApplicationContext()).thenReturn(activity);


        Mockito.doNothing().when(activity).setContentView(Mockito.anyInt());


        Button btn = Mockito.mock(Button.class);

        Mockito.when(activity.findViewById(R.id.submitButton)).thenReturn(btn);


        assertEquals(btn.getVisibility(), View.VISIBLE);
    }
}