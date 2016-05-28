package com.studio.kartuimunisasi.ui.dashboard.mvp;

/**
 * Created by NwP.
 */
public class DashboardModel {
    public static class DashboardMenu {
        private String name;
        private String image;
        private int imageResource;

        public DashboardMenu(String name, String image, int imageResource) {
            this.name = name;
            this.image = image;
            this.imageResource = imageResource;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getImageResource() {
            return imageResource;
        }

        public void setImageResource(int imageResource) {
            this.imageResource = imageResource;
        }
    }
}
