package com.onasyasu.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/state")
public class StateRestController {

    private State state = new State("A");

    @RequestMapping(method = RequestMethod.GET)
    public String steate() {
        return "dafalut state";
    }


    @RequestMapping(method = RequestMethod.GET, value = "{id}")    // f
    public String getCustomer(@PathVariable char id) {
        switch (id) {
            //Aさんが叩いて
            case 'A':
                //状態がAなら
                if(state.getState().equals("A")) {
                    state.setState("B");
                    return "true";
                } else {
                    return "false";
                }
            case 'B':
                if(state.getState().equals("B")) {
                    state.setState("A");
                    return "true";
                } else {
                    return "false";
                }
            default:
                return "badRequest";
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