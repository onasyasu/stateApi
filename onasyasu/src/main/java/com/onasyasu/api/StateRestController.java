package com.onasyasu.api;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/state")
public class StateRestController {

    private State clickState = new State("A");

    private State soundState = new State("Undefined");

    @RequestMapping(method = RequestMethod.GET)
    public List<ResponseJson> getCustomer() {
        List list = new ArrayList<>();
        ResponseJson responseJsonClick = new ResponseJson("clickState",clickState.getState());
        ResponseJson responseJsonSound = new ResponseJson("soundState",soundState.getState());

        list.add(responseJsonClick);
        list.add(responseJsonSound);

        return list;
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public String getCustomer(@PathVariable String id) {
        System.out.println("Request :"+id);
        switch (id) {
            //Aさんが音を流される状況かどうか.cronで常に叩かれる
            case "getSoundableUserA":
                if (soundState.getState().equals("A")) {
                    soundState.setState("Undefined");
                    return "true\n";
                } else {
                    return "false\n";
                }
            case "getSoundableUserB":
                if (soundState.getState().equals("B")) {
                    soundState.setState("Undefined");
                    return "true\n";
                } else {
                    return "false\n";
                }
                //Aさんがクリックできる状況かどうか.dashButtonが押されたときに起動
            case "clickableA":
                if (clickState.getState().equals("A")) {
                    //Bさんの音が流れる状態
                    soundState.setState("B");
                    return "true\n";
                } else {
                    return "false\n";
                }
            case "clickableB":
                if (clickState.getState().equals("B")) {
                    soundState.setState("A");
                    return "true\n";
                } else {
                    return "false\n";
                }
                //Aさんが走り終えました.走り終わったときに叩かれる
            case "endRunA":
                soundState.setState("Undefined");
                clickState.setState("A");
                return "soundStateUpdated\n";
            case "endRunB":
                soundState.setState("Undefined");
                clickState.setState("B");
                return "soundStateUpdated\n";
            default:
                return "badRequest\n";
        }
    }
}

class State {
    private String state;

    public State(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

class ResponseJson {
    private String state;
    private String stateType;

    public ResponseJson(String state, String stateType) {
        this.state = state;
        this.stateType = stateType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateType() {
        return stateType;
    }

    public void setStateType(String stateType) {
        this.stateType = stateType;
    }
}