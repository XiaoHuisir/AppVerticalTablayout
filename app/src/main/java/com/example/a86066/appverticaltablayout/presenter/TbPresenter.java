package com.example.a86066.appverticaltablayout.presenter;

import com.example.a86066.appverticaltablayout.bean.MainBean;
import com.example.a86066.appverticaltablayout.collback.Collback;
import com.example.a86066.appverticaltablayout.model.TbModel;
import com.example.a86066.appverticaltablayout.view.TbView;

public class TbPresenter implements Collback<MainBean, String> {
    private TbView tbView;

    public void okattach(TbView tbView) {
        this.tbView = tbView;
    }

    private boolean isattach() {
        return this.tbView != null;
    }

    public void gettbpresenter() {

        TbModel model = new TbModel();
        model.getmodel(this);


    }


    @Override
    public void succeed(MainBean mainBean) {
        if (isattach()) {
            tbView.succeed(mainBean);
        }
    }

    @Override
    public void isEnit(String s) {
        if (isattach()) {
            tbView.isEnit(s);
        }
    }

    public void onattach() {
        this.tbView = null;
    }
}
