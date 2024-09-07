public class Park {
    public class Attraction {
        private String name;
        private String openingTime;
        private String closingTime;
        private double ticketPrice;

        public Attraction(String name, String openingTime, String closingTime, double ticketPrice) {
            this.name = name;
            this.openingTime = openingTime;
            this.closingTime = closingTime;
            this.ticketPrice = ticketPrice;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOpeningTime() {
            return openingTime;
        }

        public void setOpeningTime(String openingTime) {
            this.openingTime = openingTime;
        }

        public String getClosingTime() {
            return closingTime;
        }

        public void setClosingTime(String closingTime) {
            this.closingTime = closingTime;
        }

        public double getTicketPrice() {
            return ticketPrice;
        }

        public void setTicketPrice(double ticketPrice) {
            this.ticketPrice = ticketPrice;
        }

        @Override
        public String toString() {
            return "Аттракцион (" +
                    "Название='" + name + '\'' +
                    ", Время открытия='" + openingTime + '\'' +
                    ", Время закрытия='" + closingTime + '\'' +
                    ", Цена билета=" + ticketPrice +
                    ')';
        }
    }
}