package com.arraigntech.testdemo.ui.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;

import com.arraigntech.testdemo.R;
import com.arraigntech.testdemo.databinding.ImagePreviewLayoutBinding;
import com.arraigntech.testdemo.ui.adapters.ImagePreviewAdapter;
import com.arraigntech.testdemo.ui.data.ResultPojo;

import java.util.List;

public class ImagePreviewDialog extends DialogFragment {

    private ImagePreviewLayoutBinding binding;
    private List<ResultPojo.Items> list;
    private int pos;

    public ImagePreviewDialog(List<ResultPojo.Items> list, int pos) {
        this.list = list;
        this.pos = pos;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.image_preview_layout, container, false);
        binding.viewPage.setAdapter(new ImagePreviewAdapter(requireContext(), list, pos));
        binding.viewPage.setCurrentItem(pos);
        binding.backIV.setOnClickListener(v -> requireActivity().onBackPressed());
        binding.nextIV.setOnClickListener(v -> binding.viewPage.setCurrentItem(binding.viewPage.getCurrentItem() + 1));
        binding.prevIV.setOnClickListener(v -> binding.viewPage.setCurrentItem(binding.viewPage.getCurrentItem() - 1));
        return binding.getRoot();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }
}
