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
    public String getCustomer(@PathVariable String id) {
        switch (id) {
            //Aさんが叩いて
            case "A":
                //状態がAなら
                if(state.getState().equals("A")) {
                    state.setState("R");
                    return "true\n";
                } else {
                    return "false\n";
                }
            case "B":
                //状態がBなら
                if(state.getState().equals("B" +
                        "" +
                        "")) {
                    state.setState("R");
                    return "true\n";
                } else {
                    return "false\n";
                }
             //AのRunnningが終了になったら
            case "endRA":
                    state.setState("A");
                    return "update";
            //BのRunnningが終了になったら
            case "endRB":
                state.setState("B");
                return "update";

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