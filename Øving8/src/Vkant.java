class Vkant extends Kant{
    protected int flyt , distance;
    protected Vkant reverse;

    public Vkant(int from , int to , int flyt , int distance) {
        super(from, to);
        this.flyt = flyt;
        this.distance = distance;
    }

    public void setReverse(Vkant vk) {
        reverse = vk;
    }
}