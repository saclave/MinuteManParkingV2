import React, { Component } from 'react';

import { Layout } from 'antd';

const { Header } = Layout;

class HomePageHeader extends Component {
    render() {
        return (
            <Header className="header">
                <div className="logo" />
            </Header>
        );
    }
}

export default HomePageHeader;