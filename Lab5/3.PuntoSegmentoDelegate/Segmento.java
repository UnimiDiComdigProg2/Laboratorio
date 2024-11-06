interface Segmento {
	public double length();
	public Punto getA(); //ritornerò un tipo covariante (Punto2D o Punto3D) a seconda della classe che mi implementa
	public Punto getB();
}