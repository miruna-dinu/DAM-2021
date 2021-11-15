package com.example.tema1workoutplan;

import java.util.List;

public interface IResponse {
    public void onSucces(List<Program> list);
    public void onError(String errorMessage);
}
