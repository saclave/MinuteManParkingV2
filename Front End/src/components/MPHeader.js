import React, { Component } from 'react';

import { Layout, Menu } from 'antd';

const { Header } = Layout;

class MPHeader extends Component {
    render() {
        return (
            <div>
                <Header className="header">
                    <div className="logo" />
                    <Menu theme="dark" mode="horizontal">
                    </Menu>
                </Header>
            </div>
        );
    }
}

export default MPHeader;