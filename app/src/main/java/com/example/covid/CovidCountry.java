package com.example.covid;

public class CovidCountry {

    String mCovidCountry,mCases,mTodayCases,mDeaths,getmTodayCases,mRecovered,mCritical;

    public CovidCountry(String mCovidCountry, String mCases) {
        this.mCovidCountry = mCovidCountry;
        this.mCases = mCases;
        this.mTodayCases = mTodayCases;
        this.mDeaths = mDeaths;
        this.getmTodayCases = getmTodayCases;
        this.mRecovered = mRecovered;
        this.mCritical = mCritical;
    }

    public String getmCovidCountry() {
        return mCovidCountry;
    }

    public String getmCases() {
        return mCases;
    }
}
