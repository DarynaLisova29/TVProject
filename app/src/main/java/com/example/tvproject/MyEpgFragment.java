package com.example.tvproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.egeniq.androidtvprogramguide.ProgramGuideFragment;
import com.egeniq.androidtvprogramguide.entity.ProgramGuideSchedule;

import org.threeten.bp.LocalDate;


public class MyEpgFragment extends ProgramGuideFragment<SimpleProgram> {


    @Override
    public boolean isTopMenuVisible() {
        return false;
    }

    @Override
    public void onScheduleClicked(@NonNull ProgramGuideSchedule<SimpleProgram> programGuideSchedule) {
    }

    @Override
    public void onScheduleSelected(@Nullable ProgramGuideSchedule<SimpleProgram> programGuideSchedule) {
    }

//    переробить фрагмент
    @Override
    public void requestRefresh() {

    }


    @Override
    public void requestingProgramGuideFor(@NonNull LocalDate localDate) {

    }
}
