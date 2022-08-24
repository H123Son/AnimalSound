package com.son.soundanimal;

import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import com.son.soundanimal.databinding.M000SplashActBinding;

public class M000SpashAct extends BaseAct<M000SplashActBinding> {

    @Override
    protected void initViews() {
        new Handler().postDelayed(this::goToMainAct, 2000);
    }

    private void goToMainAct() {
        Intent intent = new Intent();
        intent.setClass(this, M001MainAct.class);
        startActivity(intent);
    }

    @Override
    protected M000SplashActBinding initViewBinding() {
        return M000SplashActBinding.inflate(LayoutInflater.from(this));
    }

}
