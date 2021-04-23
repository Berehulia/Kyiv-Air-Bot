#!/bin/bash
docker build . -t kyivairbot
docker run --rm --entrypoint cat kyivairbot /home/kyivairbot.zip > target/kyivairbot.zip