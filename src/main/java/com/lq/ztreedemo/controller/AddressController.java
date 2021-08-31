package com.lq.ztreedemo.controller;

import com.lq.ztreedemo.pojo.Address;
import com.lq.ztreedemo.service.AddressService;
import com.lq.ztreedemo.tree.TreeNodeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @RequestMapping("/getTree")
    public List<TreeNodeMap> getTree(){
        return addressService.selectAll();
    }

    @RequestMapping("/addNode")
    public String addNode(Address address){
        String id = String.valueOf(new Date().getTime());
        address.setId(id);
        addressService.addNode(address);
        return id;
    }

    @RequestMapping("/removeNode")
    public int removeNode(String id){
        return addressService.removeNode(id);
    }

    @RequestMapping("/updateNode")
    public int updateNode(String id,String name){
        return addressService.updateNode(id,name);
    }

    @RequestMapping("/moveNode")
    public int moveNode(String nodeId,String targetNodeId){
        return addressService.moveNode(nodeId,targetNodeId);
    }
}
