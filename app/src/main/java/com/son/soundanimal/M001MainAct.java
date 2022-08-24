package com.son.soundanimal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;

import androidx.annotation.Nullable;

import com.son.soundanimal.databinding.M001MainActBinding;
import com.son.soundanimal.model.AnimalModel;

public class M001MainAct extends BaseAct<M001MainActBinding> {
    public static final String KEY_DATA = "KEY_DATA";
    private static final String TAG = M001MainAct.class.getName();
    public static final String KEY_ANIMAL = "KEY_ANIMAL";
    private int drawableId;
    private String name;

    @Override
    protected void initViews() {
        binding.ivElephant.setOnClickListener(this);
        binding.ivDog.setOnClickListener(this);
        binding.ivTurtle.setOnClickListener(this);
        binding.btDetail.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_elephant:
                doClickAnimal(view, R.drawable.ic_elephant, R.string.txt_elephant_des);
                break;
            case R.id.iv_dog:
                doClickAnimal(view, R.drawable.ic_dog, R.string.txt_dog_des);
                break;
            case R.id.iv_turtle:
                doClickAnimal(view, R.drawable.ic_turtle, R.string.txt_turtle_des);
                break;
            case R.id.bt_detail:
                showAnimalDetail();
        }
    }

    private void showAnimalDetail() {
        Intent intent = new Intent();
        intent.setClass(this, M002DetailAct.class);

        AnimalModel data = new AnimalModel(drawableId, name);
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_ANIMAL, data);
        intent.putExtra(KEY_DATA, bundle);
        Log.i(TAG, "data: " + data.getName() + "...." + data.getDrawableId());
        startActivity(intent);
        startActivityForResult(intent, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void doClickAnimal(View view, int drawableId, int description) {
        setBG(view);
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));

        name = view.getContentDescription().toString();
        this.drawableId = drawableId;
        binding.tvContent.setText(description);
        binding.btDetail.setEnabled(true);
    }

    @SuppressLint("ResourceType")
    private void setBG(View view) {
        binding.ivElephant.setBackgroundColor(Color.TRANSPARENT);
        binding.ivDog.setBackgroundColor(Color.TRANSPARENT);
        binding.ivTurtle.setBackgroundColor(Color.TRANSPARENT);
        view.setBackgroundResource(R.color.teal_700);
    }

    @Override
    protected M001MainActBinding initViewBinding() {
        return M001MainActBinding.inflate(getLayoutInflater());
    }

}
