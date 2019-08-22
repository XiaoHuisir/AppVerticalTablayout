package com.example.a86066.appverticaltablayout.presenter;

import com.example.a86066.appverticaltablayout.bean.DetailsBean;
import com.example.a86066.appverticaltablayout.collback.Collback;
import com.example.a86066.appverticaltablayout.model.DetailsModel;
import com.example.a86066.appverticaltablayout.view.DetailsView;

public class DetailsPresenter implements Collback<DetailsBean, String> {
    private DetailsView detailsView;

    public void okattach(DetailsView detailsView) {
        this.detailsView = detailsView;
    }

    private boolean isattach() {
        return this.detailsView != null;
    }

    public void getpresenter(int id) {
        DetailsModel model = new DetailsModel();
        model.getmodel(id, this);


    }


    @Override
    public void succeed(DetailsBean detailsBean) {
        if (isattach()) {
            detailsView.succeed(detailsBean);
        }
    }

    @Override
    public void isEnit(String s) {
        if (isattach()) {
            detailsView.isEnit(s);
        }
    }

    public void onattach() {
        this.detailsView = null;
    }
}
