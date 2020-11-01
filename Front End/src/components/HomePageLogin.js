import React, { Component } from 'react';

import { Link } from 'react-router-dom'

import { Affix, Form, Input, Layout, Button, Typography } from 'antd';

import { UserOutlined, LockOutlined } from '@ant-design/icons';

const { Sider } = Layout;
const { Title } = Typography;

class HomePageLogin extends Component {
    formRef = React.createRef();

    onFinish = values => {
        const account = this.getAccountByUsernameAndPassword(values.username, values.password);
        if (this.isObjectEmpty(account)) {
            console.log('Log in failed!');

            return;
        }

        console.log(account);
        this.props.authenticate(account);
        console.log('Logged in successfully!');
    };

    getAccountByUsernameAndPassword = (username, password) => {
        return this.props.accounts.find(account =>
            account.username === username &&
            account.password === password);
    }

    isObjectEmpty(object) {
        return Object.keys(object).length === 0;
    }

    render() {
        return (
            <Affix offsetTop={20}>
                <Sider width={300} className="site-layout-background">
                    <div className="home-page-login">
                        <Title>Log In</Title>
                        <Form
                            name="normal_login"
                            className="login-form"
                            initialValues={{
                                remember: true,
                            }}
                            onFinish={this.onFinish}
                        >
                            <Form.Item
                                name="username"
                                rules={[
                                    {
                                        required: true,
                                        message: 'Please input your username!',
                                    },
                                ]}
                            >
                                <Input prefix={<UserOutlined className="site-form-item-icon" />} placeholder="Username" />
                            </Form.Item>
                            <Form.Item
                                name="password"
                                rules={[
                                    {
                                        required: true,
                                        message: 'Please input your password!',
                                    },
                                ]}
                            >
                                <Input
                                    prefix={<LockOutlined className="site-form-item-icon" />}
                                    type="password"
                                    placeholder="Password"
                                />
                            </Form.Item>
                            <Form.Item>
                                <Button type="primary" htmlType="submit" block>
                                    Log in
                                </Button>
                                or create an account <Link to="/create">here</Link>
                            </Form.Item>
                        </Form>
                    </div>
                </Sider>
            </Affix>
        );
    }
}

export default HomePageLogin;