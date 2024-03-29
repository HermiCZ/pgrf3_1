package cz.uhk.herman.pgrf3.objects.impl;

import cz.uhk.herman.pgrf3.objects.RenderedObject;
import cz.uhk.herman.pgrf3.transforms.Vec3D;

public class SphericSphere implements RenderedObject {

	@Override
	public Vec3D compute(double x, double y) {
		double t = Math.PI * 0.5 - Math.PI * y *2;
		double s = 2 * Math.PI * x *2;
		
		double r = 1+0.2*Math.sin(6*s)*Math.sin(5*t);
		r*= 10;
		
		return new Vec3D(
				Math.sin(t) * Math.cos(s) * r ,
				Math.sin(t) * Math.sin(s) * r , 
				Math.cos(s) * r );
	}

}
