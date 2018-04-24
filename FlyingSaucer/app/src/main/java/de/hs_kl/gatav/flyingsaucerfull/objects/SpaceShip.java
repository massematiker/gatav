package de.hs_kl.gatav.flyingsaucerfull.objects;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class SpaceShip extends SpaceObject {

    private static float FULL_HEALTH=1.0f;

    private float rotation = 0.0f;
    private float angularVelocity = 10.0f;
    private float deathRotationVelocity = 1.0f;

    private float ringRotation = 0.0f;
    private float ringAngularVelocity = -30.0f;

    private float ringHealth = FULL_HEALTH; // 1.0 = full, 0.0 = dead, <0.2 = blinking <=0.1 = death rotation

    private static float[] colorEnergyHigh = { 0.0f, 1.0f, 0.0f };
    private static float[] colorEnergyMedium = { 1.0f, 0.5f, 0.0f };
    private static float[] colorEnergyLow = { 1.0f, 0.0f, 0.0f };

    private static float[] colorBody = { 0.8f, 0.8f, 0.8f };

    public float getRingHealth() {
        return ringHealth;
    }

    //@formatter:off
    private static final float ring_vertices[] = {

    };
    private static final short ring_quads[] = {
            
    };

    private static final float body_vertices[] = {
            -0.095671f, 0.182819f, 0.000000f,
            -0.176777f, 0.139924f, 0.000000f,
            -0.230970f, 0.065390f, 0.000000f,
            -0.230970f, -0.065390f, 0.000000f,
            -0.176777f, -0.139924f, 0.000000f,
            -0.095671f, -0.182819f, 0.000000f,
            -0.088388f, 0.182819f, -0.036612f,
            -0.163320f, 0.139924f, -0.067649f,
            -0.213388f, 0.065390f, -0.088388f,
            -0.213388f, -0.065390f, -0.088388f,
            -0.163320f, -0.139924f, -0.067649f,
            -0.088388f, -0.182819f, -0.036612f,
            -0.067650f, 0.182819f, -0.067649f,
            -0.125000f, 0.139924f, -0.125000f,
            -0.163320f, 0.065390f, -0.163320f,
            -0.163320f, -0.065390f, -0.163320f,
            -0.125000f, -0.139924f, -0.125000f,
            -0.067650f, -0.182819f, -0.067649f,
            -0.036612f, 0.182819f, -0.088388f,
            -0.067650f, 0.139924f, -0.163320f,
            -0.088388f, 0.065390f, -0.213388f,
            -0.088388f, -0.065390f, -0.213388f,
            -0.067650f, -0.139924f, -0.163320f,
            -0.036612f, -0.182819f, -0.088388f,
            -0.000000f, 0.182819f, -0.095671f,
            -0.000000f, 0.139924f, -0.176777f,
            -0.000000f, 0.065390f, -0.230970f,
            -0.000000f, -0.065390f, -0.230970f,
            -0.000000f, -0.139924f, -0.176777f,
            -0.000000f, -0.182819f, -0.095671f,
            0.036612f, 0.182819f, -0.088388f,
            0.067649f, 0.139924f, -0.163320f,
            0.088388f, 0.065390f, -0.213388f,
            0.088388f, -0.065390f, -0.213388f,
            0.067649f, -0.139924f, -0.163320f,
            0.036612f, -0.182819f, -0.088388f,
            -0.000000f, 0.197882f, 0.000000f,
            0.067649f, 0.182819f, -0.067649f,
            0.125000f, 0.139924f, -0.125000f,
            0.163320f, 0.065390f, -0.163320f,
            0.163320f, -0.065390f, -0.163320f,
            0.125000f, -0.139924f, -0.125000f,
            0.067649f, -0.182819f, -0.067649f,
            0.088388f, 0.182819f, -0.036612f,
            0.163320f, 0.139924f, -0.067649f,
            0.213388f, 0.065390f, -0.088388f,
            0.213388f, -0.065390f, -0.088388f,
            0.163320f, -0.139924f, -0.067649f,
            0.088388f, -0.182819f, -0.036612f,
            -0.000000f, -0.197882f, 0.000000f,
            0.095671f, 0.182819f, 0.000000f,
            0.176777f, 0.139924f, 0.000000f,
            0.230970f, 0.065390f, 0.000000f,
            0.230970f, -0.065390f, 0.000000f,
            0.176777f, -0.139924f, 0.000000f,
            0.095671f, -0.182819f, 0.000000f,
            0.088388f, 0.182819f, 0.036612f,
            0.163320f, 0.139924f, 0.067649f,
            0.213388f, 0.065390f, 0.088388f,
            0.213388f, -0.065390f, 0.088388f,
            0.163320f, -0.139924f, 0.067649f,
            0.088388f, -0.182819f, 0.036612f,
            0.067649f, 0.182819f, 0.067649f,
            0.125000f, 0.139924f, 0.125000f,
            0.163320f, 0.065390f, 0.163320f,
            0.163320f, -0.065390f, 0.163320f,
            0.125000f, -0.139924f, 0.125000f,
            0.067649f, -0.182819f, 0.067649f,
            0.036612f, 0.182819f, 0.088388f,
            0.067649f, 0.139924f, 0.163320f,
            0.088388f, 0.065390f, 0.213388f,
            0.088388f, -0.065390f, 0.213388f,
            0.067649f, -0.139924f, 0.163320f,
            0.036612f, -0.182819f, 0.088388f,
            -0.000000f, 0.182819f, 0.095671f,
            -0.000000f, 0.139924f, 0.176777f,
            -0.000000f, 0.065390f, 0.230970f,
            -0.000000f, -0.065390f, 0.230970f,
            -0.000000f, -0.139924f, 0.176777f,
            -0.000000f, -0.182819f, 0.095671f,
            -0.036612f, 0.182819f, 0.088388f,
            -0.067650f, 0.139924f, 0.163320f,
            -0.088388f, 0.065390f, 0.213388f,
            -0.088388f, -0.065390f, 0.213388f,
            -0.067650f, -0.139924f, 0.163320f,
            -0.036612f, -0.182819f, 0.088388f,
            -0.067650f, 0.182819f, 0.067649f,
            -0.125000f, 0.139924f, 0.125000f,
            -0.163320f, 0.065390f, 0.163320f,
            -0.163320f, -0.065390f, 0.163320f,
            -0.125000f, -0.139924f, 0.125000f,
            -0.067650f, -0.182819f, 0.067649f,
            -0.088388f, 0.182819f, 0.036612f,
            -0.163320f, 0.139924f, 0.067649f,
            -0.213388f, 0.065390f, 0.088388f,
            -0.213388f, -0.065390f, 0.088388f,
            -0.163320f, -0.139924f, 0.067649f,
            -0.088388f, -0.182819f, 0.036612f
    };
    private static final short body_quads[] = {
            56-49, 57-49, 51-49, 50-49,
            58-49, 59-49, 53-49, 52-49,
            50-49, 49-49, 55-49, 56-49,
            59-49, 60-49, 54-49, 53-49,
            65-49, 66-49, 60-49, 59-49,
            62-49, 63-49, 57-49, 56-49,
            64-49, 65-49, 59-49, 58-49,
            61-49, 62-49, 56-49, 55-49,
            71-49, 72-49, 66-49, 65-49,
            68-49, 69-49, 63-49, 62-49,
            70-49, 71-49, 65-49, 64-49,
            67-49, 68-49, 62-49, 61-49,
            77-49, 78-49, 72-49, 71-49,
            74-49, 75-49, 69-49, 68-49,
            76-49, 77-49, 71-49, 70-49,
            73-49, 74-49, 68-49, 67-49,
            83-49, 84-49, 78-49, 77-49,
            80-49, 81-49, 75-49, 74-49,
            82-49, 83-49, 77-49, 76-49,
            79-49, 80-49, 74-49, 73-49,
            90-49, 91-49, 84-49, 83-49,
            87-49, 88-49, 81-49, 80-49,
            89-49, 90-49, 83-49, 82-49,
            86-49, 87-49, 80-49, 79-49,
            96-49, 97-49, 91-49, 90-49,
            93-49, 94-49, 88-49, 87-49,
            95-49, 96-49, 90-49, 89-49,
            92-49, 93-49, 87-49, 86-49,
            103-49, 104-49, 97-49, 96-49,
            100-49, 101-49, 94-49, 93-49,
            102-49, 103-49, 96-49, 95-49,
            99-49, 100-49, 93-49, 92-49,
            109-49, 110-49, 104-49, 103-49,
            106-49, 107-49, 101-49, 100-49,
            108-49, 109-49, 103-49, 102-49,
            105-49, 106-49, 100-49, 99-49,
            115-49, 116-49, 110-49, 109-49,
            112-49, 113-49, 107-49, 106-49,
            114-49, 115-49, 109-49, 108-49,
            111-49, 112-49, 106-49, 105-49,
            121-49, 122-49, 116-49, 115-49,
            118-49, 119-49, 113-49, 112-49,
            120-49, 121-49, 115-49, 114-49,
            117-49, 118-49, 112-49, 111-49,
            127-49, 128-49, 122-49, 121-49,
            124-49, 125-49, 119-49, 118-49,
            126-49, 127-49, 121-49, 120-49,
            123-49, 124-49, 118-49, 117-49,
            133-49, 134-49, 128-49, 127-49,
            130-49, 131-49, 125-49, 124-49,
            132-49, 133-49, 127-49, 126-49,
            129-49, 130-49, 124-49, 123-49,
            139-49, 140-49, 134-49, 133-49,
            136-49, 137-49, 131-49, 130-49,
            138-49, 139-49, 133-49, 132-49,
            135-49, 136-49, 130-49, 129-49,
            145-49, 146-49, 140-49, 139-49,
            142-49, 143-49, 137-49, 136-49,
            144-49, 145-49, 139-49, 138-49,
            141-49, 142-49, 136-49, 135-49,
            53-49, 54-49, 146-49, 145-49,
            50-49, 51-49, 143-49, 142-49,
            52-49, 53-49, 145-49, 144-49,
            49-49, 50-49, 142-49, 141-49,
            131-49, 132-49, 126-49, 125-49,
            125-49, 126-49, 120-49, 119-49,
            119-49, 120-49, 114-49, 113-49,
            113-49, 114-49, 108-49, 107-49,
            107-49, 108-49, 102-49, 101-49,
            101-49, 102-49, 95-49, 94-49,
            94-49, 95-49, 89-49, 88-49,
            88-49, 89-49, 82-49, 81-49,
            81-49, 82-49, 76-49, 75-49,
            75-49, 76-49, 70-49, 69-49,
            69-49, 70-49, 64-49, 63-49,
            63-49, 64-49, 58-49, 57-49,
            57-49, 58-49, 52-49, 51-49,
            51-49, 52-49, 144-49, 143-49,
            143-49, 144-49, 138-49, 137-49,
            137-49, 138-49, 132-49, 131-49
    };
    private static final short body_triangles[] = {
            60-49, 98-49, 54-49,
            55-49, 49-49, 85-49,
            66-49, 98-49, 60-49,
            85-49, 61-49, 55-49,
            72-49, 98-49, 66-49,
            85-49, 67-49, 61-49,
            78-49, 98-49, 72-49,
            85-49, 73-49, 67-49,
            84-49, 98-49, 78-49,
            85-49, 79-49, 73-49,
            91-49, 98-49, 84-49,
            85-49, 86-49, 79-49,
            97-49, 98-49, 91-49,
            85-49, 92-49, 86-49,
            104-49, 98-49, 97-49,
            85-49, 99-49, 92-49,
            110-49, 98-49, 104-49,
            85-49, 105-49, 99-49,
            116-49, 98-49, 110-49,
            85-49, 111-49, 105-49,
            122-49, 98-49, 116-49,
            85-49, 117-49, 111-49,
            128-49, 98-49, 122-49,
            85-49, 123-49, 117-49,
            134-49, 98-49, 128-49,
            85-49, 129-49, 123-49,
            140-49, 98-49, 134-49,
            85-49, 135-49, 129-49,
            146-49, 98-49, 140-49,
            85-49, 141-49, 135-49,
            54-49, 98-49, 146-49,
            85-49, 49-49, 141-49
    };
    //@formatter:on
    private static FloatBuffer ringVerticesBuffer;
    private static ShortBuffer ringQuadsBuffer;

    private static FloatBuffer bodyVerticesBuffer;
    private static ShortBuffer bodyQuadsBuffer;
    private static ShortBuffer bodyTrianglesBuffer;

    private static boolean buffersInitialized = false;

    public SpaceShip() {
        // set default scale to 2
        scale = 2;

        if (!buffersInitialized) {
            // Initialize buffers
            ByteBuffer ringVerticesBB = ByteBuffer.allocateDirect(ring_vertices.length * 4);
            ringVerticesBB.order(ByteOrder.nativeOrder());
            ringVerticesBuffer = ringVerticesBB.asFloatBuffer();
            ringVerticesBuffer.put(ring_vertices);
            ringVerticesBuffer.position(0);

            ByteBuffer ringQuadsBB = ByteBuffer.allocateDirect(ring_quads.length * 2);
            ringQuadsBB.order(ByteOrder.nativeOrder());
            ringQuadsBuffer = ringQuadsBB.asShortBuffer();
            ringQuadsBuffer.put(ring_quads);
            ringQuadsBuffer.position(0);

            ByteBuffer bodyVerticesBB = ByteBuffer.allocateDirect(body_vertices.length * 4);
            bodyVerticesBB.order(ByteOrder.nativeOrder());
            bodyVerticesBuffer = bodyVerticesBB.asFloatBuffer();
            bodyVerticesBuffer.put(body_vertices);
            bodyVerticesBuffer.position(0);

            ByteBuffer bodyQuadsBB = ByteBuffer.allocateDirect(body_quads.length * 2);
            bodyQuadsBB.order(ByteOrder.nativeOrder());
            bodyQuadsBuffer = bodyQuadsBB.asShortBuffer();
            bodyQuadsBuffer.put(body_quads);
            bodyQuadsBuffer.position(0);

            ByteBuffer bodyTrianglesBB = ByteBuffer.allocateDirect(body_triangles.length * 2);
            bodyTrianglesBB.order(ByteOrder.nativeOrder());
            bodyTrianglesBuffer = bodyTrianglesBB.asShortBuffer();
            bodyTrianglesBuffer.put(body_triangles);
            bodyTrianglesBuffer.position(0);

            buffersInitialized = true;
        }
    }

    public void damage(float dmg) {
        ringHealth -= dmg;
    }

    public void resetHealth() {
        ringHealth = FULL_HEALTH;
        deathRotationVelocity=1.0f;
    }

    @Override
    public void draw(GL10 gl) {
        gl.glMatrixMode(GL10.GL_MODELVIEW);

        gl.glPushMatrix();
        {
            gl.glMultMatrixf(transformationMatrix, 0);

            gl.glScalef(scale, scale, scale);

            gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

            gl.glLineWidth(2.0f);

            // draw ring
            gl.glPushMatrix();
            {
                gl.glRotatef(ringRotation, 0, 1, 0);

                gl.glVertexPointer(3, GL10.GL_FLOAT, 0, ringVerticesBuffer);
                setRingColor(gl);
                for (int i = 0; i < (ring_quads.length / 4); i++) {
                    ringQuadsBuffer.position(4 * i);
                    gl.glDrawElements(GL10.GL_LINE_LOOP, 4,
                            GL10.GL_UNSIGNED_SHORT, ringQuadsBuffer);
                }
                ringQuadsBuffer.position(0);
            }
            gl.glPopMatrix();

            // draw body
            gl.glPushMatrix();
            {
                gl.glRotatef(rotation, 0, 1, 0);
                gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bodyVerticesBuffer);
                gl.glColor4f(colorBody[0], colorBody[1], colorBody[2], 0);
                for (int i = 0; i < (body_triangles.length / 3); i++) {
                    bodyTrianglesBuffer.position(3 * i);
                    gl.glDrawElements(GL10.GL_LINE_LOOP, 3, GL10.GL_UNSIGNED_SHORT, bodyTrianglesBuffer);
                }
                bodyTrianglesBuffer.position(0);

                for (int i = 0; i < (body_quads.length / 4); i++) {
                    bodyQuadsBuffer.position(4 * i);
                    gl.glDrawElements(GL10.GL_LINE_LOOP, 4, GL10.GL_UNSIGNED_SHORT, bodyQuadsBuffer);
                }
                bodyQuadsBuffer.position(0);

            }
            gl.glPopMatrix();


            gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        }
        gl.glPopMatrix();
    }

    private void setRingColor(GL10 gl) {
        float r, g, b;
        if (ringHealth > 0.6f) {
            r = colorEnergyHigh[0];
            g = colorEnergyHigh[1];
            b = colorEnergyHigh[2];
        } else if (ringHealth > 0.2f) {
            r = colorEnergyMedium[0];
            g = colorEnergyMedium[1];
            b = colorEnergyMedium[2];
        } else {
            if (Math.random() < 0.7) {		// random flickering of the ring "near death experience"
                r = colorEnergyLow[0];
                g = colorEnergyLow[1];
                b = colorEnergyLow[2];
            } else {
                r = 0;
                g = 0;
                b = 0;
            }
        }

        gl.glColor4f(r, g, b, 0);
    }

    @Override
    public void update(float fracSec) {
        updatePosition(fracSec);

        if(ringHealth<=0.2) deathRotationVelocity=20.0f;
        if(ringHealth<=0.0) {deathRotationVelocity=0.0f; }

        rotation += fracSec * angularVelocity * deathRotationVelocity;
        ringRotation += fracSec * ringAngularVelocity;

    }

}

