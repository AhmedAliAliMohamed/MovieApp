package com.example.movieapp.models;

import java.util.List;

public class ModelForRecommendation {


     /**
     * page : 1
     * results : [{"adult":false,"backdrop_path":"/96AK8Fj12MYSelyB6AEPI0EKoty.jpg","genre_ids":[53,18],"id":526682,"original_language":"en","original_title":"Blackmark","overview":"1963 Military Industrialist Arthur Blackmark must race against the clock to stop an international incident which threatens to end the world.","poster_path":"/jtzsuwWaVHCv4zXi0YQYffAkQVt.jpg","release_date":"2018-08-07","title":"Blackmark","video":false,"vote_average":6,"vote_count":16,"popularity":17.618},{"id":694919,"video":false,"vote_count":5,"vote_average":5.7,"title":"Money Plane","release_date":"2020-09-29","original_language":"en","original_title":"Money Plane","genre_ids":[28],"backdrop_path":"/9Y12EdkIVvYir3uTcZGjqfXWBUv.jpg","adult":false,"overview":"A professional thief with $40 million in debt and his family's life on the line must commit one final heist - rob a futuristic airborne casino filled with the world's most dangerous criminals.","poster_path":"/6CoRTJTmijhBLJTUNoVSUNxZMEI.jpg","popularity":2261.976},{"id":724989,"video":false,"vote_count":77,"vote_average":5,"title":"Hard Kill","release_date":"2020-08-25","original_language":"en","original_title":"Hard Kill","genre_ids":[28,53],"backdrop_path":"/86L8wqGMDbwURPni2t7FQ0nDjsH.jpg","adult":false,"overview":"The work of billionaire tech CEO Donovan Chalmers is so valuable that he hires mercenaries to protect it, and a terrorist group kidnaps his daughter just to get it.","poster_path":"/ugZW8ocsrfgI95pnQ7wrmKDxIe.jpg","popularity":1341.059},{"id":722603,"video":false,"vote_count":40,"vote_average":5.8,"title":"Battlefield 2025","release_date":"2020-07-07","original_language":"en","original_title":"Battlefield 2025","genre_ids":[28,27,878],"backdrop_path":"/m7QpUAeI2xTCJyAVl9J9z5dBTSb.jpg","adult":false,"overview":"Weekend campers, an escaped convict, young lovers and a police officer experience a night of terror when a hostile visitor from another world descends on a small Arizona town.","poster_path":"/w6e0XZreiyW4mGlLRHEG8ipff7b.jpg","popularity":407.234},{"id":661677,"video":false,"vote_count":27,"vote_average":7.2,"title":"So Much Love to Give","release_date":"2020-09-09","original_language":"es","original_title":"Corazón loco","genre_ids":[35],"backdrop_path":"/uwAH0sWz51fXG5d0d86i7UV3o9a.jpg","adult":false,"overview":"A bigamist with one family in Buenos Aires and the other in Mar del Plata sees his life turned upside down when his wives discover what he has hidden from them for so many years and unite to take revenge.","poster_path":"/uSwCLbElGgz7HzWEHwnSfQtP2OC.jpg","popularity":217.726}]
     * total_pages : 1
     * total_results : 5
     */

    private int page;
    private int total_pages;
    private int total_results;
    private List<ResultsBean> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * adult : false
         * backdrop_path : /96AK8Fj12MYSelyB6AEPI0EKoty.jpg
         * genre_ids : [53,18]
         * id : 526682
         * original_language : en
         * original_title : Blackmark
         * overview : 1963 Military Industrialist Arthur Blackmark must race against the clock to stop an international incident which threatens to end the world.
         * poster_path : /jtzsuwWaVHCv4zXi0YQYffAkQVt.jpg
         * release_date : 2018-08-07
         * title : Blackmark
         * video : false
         * vote_average : 6
         * vote_count : 16
         * popularity : 17.618
         */

        private boolean adult;
        private String backdrop_path;
        private int id;
        private String original_language;
        private String original_title;
        private String overview;
        private String poster_path;
        private String release_date;
        private String title;
        private boolean video;
        private float vote_average;
        private int vote_count;
        private double popularity;
        private List<Integer> genre_ids;

        public boolean isAdult() {
            return adult;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public void setOriginal_language(String original_language) {
            this.original_language = original_language;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isVideo() {
            return video;
        }

        public void setVideo(boolean video) {
            this.video = video;
        }

        public float getVote_average() {
            return vote_average;
        }

        public void setVote_average(float vote_average) {
            this.vote_average = vote_average;
        }

        public int getVote_count() {
            return vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public List<Integer> getGenre_ids() {
            return genre_ids;
        }

        public void setGenre_ids(List<Integer> genre_ids) {
            this.genre_ids = genre_ids;
        }
    }
}
