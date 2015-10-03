__author__ = 'aizhan'
# you can write to stdout for debugging purposes, e.g.
# print "this is a debug message"
import math

def solution(S):
    # write your code in Python 2.7
    # Map of phone numbers to tuple: (total duration in seconds, total cost in cents)
    all_values = {}
    for record in S.split('\n'):
        t = record.split(',')
        seconds = duration_str_to_sec(t[0])
        cost = calc_cost(seconds)
        number_str = t[1]
        tuple = all_values.get(number_str, None)
        if tuple is None:
            all_values[number_str] = (seconds, cost)
        else:
            prev_tuple = all_values[number_str]
            all_values[number_str] = (prev_tuple[0] + seconds, prev_tuple[1] + cost)

    max_duration = -1
    discount_number = []
    for k in all_values.keys():
        tuple = all_values[k]
        duration = tuple[0]
        if duration > max_duration:
            max_duration = duration
            discount_number = [k]
        elif duration == max_duration:
            discount_number.append(k)

    smallest_number = 999999999
    if len(discount_number) > 1:
        for num in discount_number:
            new_number = phone_number_int(num)
            if new_number < smallest_number:
                smallest_number = new_number
    else:
        smallest_number = phone_number_int(discount_number[0])

    total_cost = 0
    for phone_number in all_values.keys():
        if phone_number_int(phone_number) == smallest_number:
            continue
        else:
            total_cost += all_values[phone_number][1]

    return total_cost


def phone_number_int(s):
    return int(s.replace('-', ''))


def duration_str_to_sec(s):
    tokens = s.split(':')
    total_time = int(tokens[0]) * 3600 + int(tokens[1]) * 60 + int(tokens[2])
    return total_time

def calc_cost(sec):
    if sec < 300:
        return 3 * sec
    else:
        return int(150 * math.ceil(sec/60.0))

# def main():
# 	#TEST
# 	ACCESS_TOKEN = keys.INSTA_ACCESS_TOKEN
# 	userid = getUserId("jessicaalba", ACCESS_TOKEN)
# 	picUrls = getPicsOfUser(userid, 25, ACCESS_TOKEN)
#     #print picUrls

if __name__ == "__main__":
    # print duration_str_to_sec('00:05:30')
    print calc_cost(301)
    # # print calc_cost(300)
    # print solution("00:01:07,400-234-090\n00:05:01,701-080-080\n00:05:00,400-234-090")