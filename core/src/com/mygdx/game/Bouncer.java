package com.mygdx.game;

public class Bouncer {

    int x;
    int y;
    int w;
    int h;
    float speed;
    float x_dir;
    float y_dir;

    public Bouncer(int _w, int _h, float _speed){
        w = _w;
        h = _h;
        speed = _speed;
        x = 0; y = 0;
        x_dir = 1.0f; y_dir = 1.0f;
    }

    public void resize(int _w, int _h){
        w = _w;
        h = _h;
        if (x > w) {x = w;}
        if (y > h) {y = h;}
    }

    public void step(float delta){
        x += x_dir * speed;
        y += y_dir * speed;
        if (x > w) {
            x = w - (x - w);
            x_dir = -1.0f;
        }
        if (y > h) {
            y = h - (y - h);
            y_dir = -1.0f;
        }
        if (x < 0) {
            x = -x;
            x_dir = 1.0f;
        }
        if (y < 0) {
            y = -y;
            y_dir = 1.0f;
        }
    }

    public int get_pos_x() { return x; }
    public int get_pos_y() { return y; }
}
