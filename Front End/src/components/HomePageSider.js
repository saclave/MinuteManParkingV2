import React, { Component } from 'react';

import { Layout, Menu } from 'antd';
import { QuestionCircleOutlined, AreaChartOutlined, LaptopOutlined } from '@ant-design/icons';

const { Sider } = Layout;

class HomePageSider extends Component {
    render() {
        return (
            <div>
                <Sider width={200} className="site-layout-background">
                    <Menu
                        mode="inline"
                        defaultSelectedKeys={['1']}
                        defaultOpenKeys={['sub1']}
                        style={{ height: '100%', borderRight: 0 }}
                    >
                        <Menu.Item key="1" icon={<LaptopOutlined />}>Services</Menu.Item>
                        <Menu.Item key="2" icon={<AreaChartOutlined />}>Map</Menu.Item>
                        <Menu.Item key="3" icon={<QuestionCircleOutlined />}>About Us</Menu.Item>
                    </Menu>
                </Sider>
            </div>
        );
    }
}

export default HomePageSider;