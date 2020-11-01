import React, { Component } from 'react';

import { Typography } from 'antd';

const { Title } = Typography;

class HomePageServices extends Component {
    render() {
        return (
            <div className="home-page-content">
                <Title>Services</Title>
            </div>
        );
    }
}

export default HomePageServices;