package cz.uhk.herman.pgrf3.gui;

import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import cz.uhk.herman.pgrf3.objects.RenderedObject;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JOGLApp {

    private static final int FPS = 60; // animator's target frames per second

    Renderer ren = new Renderer();

    public static void main(String[] args) {
        new JOGLApp().start();
    }

    private void start() {
        try {
            Gui gui = new Gui(this);

            // setup OpenGL Version 2
            GLProfile profile = GLProfile.get(GLProfile.GL2);
            GLCapabilities capabilities = new GLCapabilities(profile);

            // The canvas is the widget that's drawn in the JFrame
            GLCanvas canvas = new GLCanvas(capabilities);
            canvas.addGLEventListener(ren);
            canvas.addMouseListener(ren);
            canvas.addMouseMotionListener(ren);
            canvas.addKeyListener(ren);
            canvas.setSize(512, 384);

            gui.window.add(canvas);

            // shutdown the program on windows close event
            //final Animator animator = new Animator(canvas);
            final FPSAnimator animator = new FPSAnimator(canvas, FPS, true);

            gui.window.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    new Thread() {
                        @Override
                        public void run() {
                            if (animator.isStarted()) {
                                animator.stop();
                            }
                            System.exit(0);
                        }
                    }.start();
                }
            });
            gui.window.pack();
            gui.window.setVisible(true);
            animator.start(); // start the animation loops

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
