#version 330
in vec2 inPosition; // vstup z vertex bufferu
out vec3 vertColor; // vystup do dalsich casti retezce
uniform float time;
void main() {
	vec2 position = inPosition;
	gl_Position = vec4(position, 0.0, 1.0); 
	vertColor = vec3(position.x, position,y, 0.5);
} 
