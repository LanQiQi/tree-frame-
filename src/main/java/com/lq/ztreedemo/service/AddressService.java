package com.lq.ztreedemo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lq.ztreedemo.mapper.AddressMapper;
import com.lq.ztreedemo.pojo.Address;
import com.lq.ztreedemo.tree.TreeNodeConfig;
import com.lq.ztreedemo.tree.TreeNodeMap;
import com.lq.ztreedemo.util.TreeUtil;
import com.lq.ztreedemo.util.TreeUtil.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressMapper addressMapper;

    public List<TreeNodeMap> selectAll(){
        List<Address> addresses = addressMapper.selectList(null);
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        treeNodeConfig.setParentIdKey("pid");
        List<TreeNodeMap> list = TreeUtil.build(addresses, "000000", treeNodeConfig, new Convert<Address>() {
            @Override
            public void convert(Address treeObject, TreeNodeMap treeNode) {
                treeNode.setId(treeObject.getId());
                treeNode.setParentId(treeObject.getPid());
                treeNode.setName(treeObject.getName());
                treeNode.extra("level", treeObject.getLevel());
            }
        });

        return list;
    }

    public int addNode(Address address){
        return addressMapper.insert(address);
    }

    public int removeNode(String id) {
//        return addressMapper.deleteById(id);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("pid",id);
        List<Address> list = addressMapper.selectList(wrapper);

        if (list!=null&&list.size()>0){
            for (Address address:list){
                removeNode(address.getId());
            }
        }

        return addressMapper.deleteById(id);
    }

    public int updateNode(String id, String name) {
        Address address = addressMapper.selectById(id);
        address.setName(name);

        int flag = addressMapper.updateById(address);
        return flag;
    }

    public int moveNode(String nodeId, String targetNodeId) {
        if (targetNodeId.equals("000000")){
            setLevel(nodeId,0);
        }else {
            Address targetAddress = addressMapper.selectById(targetNodeId);
            setLevel(nodeId, targetAddress.getLevel() + 1);
        }

        Address address = addressMapper.selectById(nodeId);

        String newPid=targetNodeId==""?"000000":targetNodeId;
        address.setPid(newPid);

        int i = addressMapper.updateById(address);
        return i;
    }

    public int setLevel(String id,int level){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("pid",id);
        List<Address> list = addressMapper.selectList(wrapper);

        if (list!=null && list.size()!=0){
            for (Address address:list){
                setLevel(address.getId(),level+1);
            }
        }

        Address address = addressMapper.selectById(id);
        address.setLevel(level);
        return addressMapper.updateById(address);
    }
}
