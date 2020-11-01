import React, { Component } from 'react';

import HomePageAboutUs from './HomePageAboutUs';
import HomePageHeader from './HomePageHeader';
import HomePageLogin from './HomePageLogin';
import HomePageMap from './HomePageMap';
import HomePageSider from './HomePageSider';
import HomePageServices from './HomePageServices';

import { Layout } from 'antd';

const { Content } = Layout;

class HomePage extends Component {
    render() {
        return (
            <Layout>
                <HomePageHeader />
                <Layout>
                    <HomePageSider />
                    <Layout style={{ padding: '0 24px 24px' }}>
                        <br />
                        <Content
                            className="site-layout-background"
                            style={{
                                padding: 24,
                                margin: 0,
                                minHeight: 280,
                            }}
                        >
                            <HomePageServices />
                            <HomePageMap />
                            <HomePageAboutUs />
                        </Content>
                    </Layout>
                    <HomePageLogin />
                </Layout>
            </Layout>
        );
    }
}

export default HomePage;