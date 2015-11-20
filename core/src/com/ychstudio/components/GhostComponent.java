package com.ychstudio.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.box2d.Body;
import com.ychstudio.ai.GhostAI;
import com.ychstudio.ai.fsm.GhostAgent;
import com.ychstudio.ai.fsm.GhostState;

public class GhostComponent implements Component {

    // state
    public static final int MOVE_UP = 0;
    public static final int MOVE_DOWN = 1;
    public static final int MOVE_LEFT = 2;
    public static final int MOVE_RIGHT = 3;
    public static final int ESCAPE = 4;
    public static final int DIE = 5;

    public GhostAI ai;
    public GhostAgent ghostAgent;
    
    private Body body;
    
    public int currentState;

    public GhostComponent(Body body, float boundingRadius) {
        this.body = body;
        ai = new GhostAI(body, boundingRadius);
        ghostAgent = new GhostAgent(this);
        ghostAgent.stateMachine.setInitialState(GhostState.MOVE_UP);
        currentState = MOVE_UP;
    }
    
    public Body getBody() {
        return body;
    }
}
