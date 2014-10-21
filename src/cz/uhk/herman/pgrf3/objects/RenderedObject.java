package cz.uhk.herman.pgrf3.objects;

import cz.uhk.herman.pgrf3.transforms.Vec3D;

public interface RenderedObject {

	public Vec3D compute(double x, double y);
	
}
