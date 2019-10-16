class Vkant {

    int from, to, flyt , distance;
    Vkant reverse;

    public Vkant(int from , int to , int flyt , int distance) {
        this.from = from;
        this.to = to;
        this.flyt = flyt;
        this.distance = distance;
    }

    public void setReverse(Vkant vk) {
        reverse = vk;
    }
}