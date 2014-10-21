package cz.uhk.herman.pgrf3.gui;

import cz.uhk.herman.pgrf3.objects.RenderedObject;
import cz.uhk.herman.pgrf3.objects.impl.CartesianCube;
import javax.media.opengl.GL2;

import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import cz.uhk.herman.pgrf3.utils.OGLBuffers;
import cz.uhk.herman.pgrf3.utils.ShaderUtils;

public class Renderer implements GLEventListener, MouseListener, MouseMotionListener, KeyListener {

    GL2 gl;
    GLAutoDrawable glDrawable;
    GLU glu;
    int width, height;

    OGLBuffers buffers, buffers2;

    int shaderProgram, shaderProgram2, locTime, locTime2;

    float time = 0;

    public void init(GLAutoDrawable drawable) {
        glDrawable = drawable;
        gl = glDrawable.getGL().getGL2();

        System.out.println("Init GL is " + gl.getClass().getName());
        System.out.println("OpenGL version " + gl.glGetString(GL2.GL_VERSION));
        System.out.println("OpenGL vendor " + gl.glGetString(GL2.GL_VENDOR));
        System.out.println("OpenGL renderer " + gl.glGetString(GL2.GL_RENDERER));
        System.out.println("OpenGL extension " + gl.glGetString(GL2.GL_EXTENSIONS));

        shaderProgram = ShaderUtils.loadProgram(gl, "./shader/start");
        shaderProgram2 = ShaderUtils.loadProgram(gl, "./shader/start2");
        createBuffers(new CartesianCube());

        locTime = gl.glGetUniformLocation(shaderProgram, "time");
        locTime2 = gl.glGetUniformLocation(shaderProgram2, "time"); // zde by
        // byt
        // nemuselo,
        // time je v
        // obou
        // programech
        // prvni
        // uniform
    }

    void createBuffers(RenderedObject renderedObject) {
//        float[] vertexBufferData = {
//            -1, -1, 0.7f, 0, 0,
//            1, 0, 0, 0.7f, 0,
//            0, 1, 0, 0, 0.7f
//        };
        float[] vertexBufferData = {
            -1, -1, 0.7f, 0, 0,
            1, 0, 0, 0.7f, 0,
            0, 1, 0, 0, 0.7f
        };
        int[] indexBufferData = {0, 1, 2};
        OGLBuffers.Attrib[] attributes = {
            new OGLBuffers.Attrib("inPosition", 2),
            new OGLBuffers.Attrib("inColor", 3)
        };

        buffers = new OGLBuffers(gl, vertexBufferData, attributes,
                indexBufferData);

        float[] vertexBufferDataPos = {
            -1, 1,
            0.5f, 0,
            -0.5f, -1
        };
        float[] vertexBufferDataCol = {
            0, 1, 1,
            1, 0, 1,
            1, 1, 1
        };
        OGLBuffers.Attrib[] attributesPos = {
            new OGLBuffers.Attrib("inPosition", 2),};
        OGLBuffers.Attrib[] attributesCol = {
            new OGLBuffers.Attrib("inColor", 3)
        };
        buffers2 = new OGLBuffers(gl, vertexBufferDataPos, attributesPos,
                indexBufferData);
        buffers2.addVertexBuffer(vertexBufferDataCol, attributesCol);

    }

    public void display(GLAutoDrawable drawable) {
        gl.glClearColor(0.1f, 0.1f, 0.1f, 1.0f);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

        time += 0.1;
        // nastaveni aktualniho shaderu, v teto ukazce nadbytecne
        gl.glUseProgram(shaderProgram);
        gl.glUniform1f(locTime, time); // musi byt nastaven spravy shader
        gl.glUseProgram(shaderProgram2);
        gl.glUniform1f(locTime2, time); // musi byt nastaven spravy shader

        // vykresleni
        buffers.draw(GL2.GL_TRIANGLES, shaderProgram);
        buffers2.draw(GL2.GL_TRIANGLES, shaderProgram2);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width,
            int height) {
        this.width = width;
        this.height = height;
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged,
            boolean deviceChanged) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void dispose(GLAutoDrawable arg0) {
    }
}
