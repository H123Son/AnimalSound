package com.son.soundanimal;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.son.soundanimal.databinding.M002DetailActBinding;
import com.son.soundanimal.model.AnimalModel;

public class M002DetailAct extends BaseAct<M002DetailActBinding> {
    private static final String TAG = M002DetailAct.class.getSimpleName();
    private final int[] animalPhotos = {R.drawable.ic_elephant, R.drawable.ic_dog, R.drawable.ic_turtle};
    private final int[] animalName = {R.string.txt_elephant, R.string.txt_dog, R.string.txt_turtle};
    private int index;

    @Override
    protected void initViews() {
        //Loi key public de lay hop trong Intent ra
        Bundle bundle = getIntent().getBundleExtra(M001MainAct.KEY_DATA);
        //Dung key private ma M001 da tiet lo de boc data() box ra
        AnimalModel data = (AnimalModel) bundle.getSerializable(M001MainAct.KEY_ANIMAL);
        binding.tvAnimalName.setText(data.getName());
        binding.ivAnimal.setImageResource(data.getDrawableId());

//        for (int itemPhoto: animalPhotos ) {
//            if (itemPhoto == data.get)
//        }
        binding.ivNext.setOnClickListener(v -> updateAnimal(index < animalPhotos.length - 1 ? index + 1 : index));
        binding.ivBack.setOnClickListener(v -> updateAnimal(index > 0 ? index - 1 : 0));

        binding.btReturn.setOnClickListener(doReturn());
    }

    private View.OnClickListener doReturn() {
        return null;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void updateAnimal(int index) {
        this.index = index;
        binding.ivAnimal.setImageResource(animalPhotos[index]);
        binding.tvAnimalName.getText().toString();

    }

    @Override
    protected M002DetailActBinding initViewBinding() {
        return M002DetailActBinding.inflate(getLayoutInflater());
    }

}
