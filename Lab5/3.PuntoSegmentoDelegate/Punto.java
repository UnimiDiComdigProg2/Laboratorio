interface Punto { //posso fare un'interfaccia per mettere in relazione Punto2D e Punto3D senza che siano in rapporto di parentela tra di loro - ora sono entrambi figli di Punto
	public double getX(); //definisco i getter per convenienza - in modo da avere una nomenclatura consistente nelle chiamate a x, y e z in Punto3D, ma l'interfaccia potrebbe anche essere vuota!
	public double getY();
}