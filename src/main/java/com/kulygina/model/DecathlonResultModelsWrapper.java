package com.kulygina.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class DecathlonResultModelsWrapper {
    private List<DecathlonResultModel> resultModels;

    public DecathlonResultModelsWrapper() {
    }

    public DecathlonResultModelsWrapper(List<DecathlonResultModel> resultModels) {
        this.resultModels = resultModels;
    }

    public List<DecathlonResultModel> getResultModels() {
        return resultModels;
    }

    public void setResultModels(List<DecathlonResultModel> resultModels) {
        this.resultModels = resultModels;
    }
}
