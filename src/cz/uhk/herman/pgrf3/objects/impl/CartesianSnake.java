package cz.uhk.herman.pgrf3.objects.impl;

import cz.uhk.herman.pgrf3.objects.RenderedObject;
import cz.uhk.herman.pgrf3.transforms.Vec3D;

public class CartesianSnake implements RenderedObject {

	@Override
	public Vec3D compute(double x, double y) {
		double s = Math.PI * 0.5 - Math.PI * y;
		double t = 2 * Math.PI * x;

		return new Vec3D(2 * (1 - s) * (3 + Math.cos(t))
				* Math.cos(2 * Math.PI * s), 4 * (1 - s) * (3 + Math.cos(t))
				* Math.sin(2 * Math.PI * s), 10 * s + (1 - s) * Math.sin(t));
	}

}
