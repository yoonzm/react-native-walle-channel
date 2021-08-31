import * as React from 'react';

import { StyleSheet, View, Text } from 'react-native';
import WalleChannel from 'react-native-walle-channel';

export default function App() {
  const [channel, setChannel] = React.useState<string | undefined>();
  const [extraInfo, setExtraInfo] = React.useState<any>();

  React.useEffect(() => {
    WalleChannel.getChannel().then(setChannel);
    WalleChannel.getExtraInfo().then(setExtraInfo);
  }, []);

  return (
    <View style={styles.container}>
      <Text>channel: {channel}</Text>
      <Text>extraInfo: {JSON.stringify(extraInfo)}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
